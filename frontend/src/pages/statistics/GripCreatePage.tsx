import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useCreateGrip } from '../../hooks/useGrips'
import { Toggle } from '../../components/ui/Toggle'
import { ChipSelect } from '../../components/ui/ChipSelect'
import { Dropdown } from '../../components/ui/Dropdown'
import { InputField } from '../../components/ui/InputField'
import { Button } from '../../components/ui/Button'
import { Collapsible } from '../../components/ui/Collapsible'
import type { GripCategory, HandMode, Finger, GripType, EdgeType } from '../../types'

const GRIP_TYPE_OPTIONS = [
  { label: 'Half Crimp', value: 'HALF_CRIMP' },
  { label: 'Full Crimp', value: 'FULL_CRIMP' },
  { label: 'Open Hand', value: 'OPEN_HAND' },
  { label: '3-Finger Drag', value: 'THREE_FINGER_DRAG' },
  { label: 'Pinch', value: 'PINCH' },
  { label: 'Mono', value: 'MONO' },
  { label: 'Pocket', value: 'POCKET' },
]

const FINGER_OPTIONS = [
  { label: 'Thumb', value: 'THUMB' },
  { label: 'Index', value: 'INDEX' },
  { label: 'Middle', value: 'MIDDLE' },
  { label: 'Ring', value: 'RING' },
  { label: 'Pinky', value: 'PINKY' },
]

const EDGE_TYPE_OPTIONS = [
  { label: 'Flat', value: 'FLAT' },
  { label: 'Uneven', value: 'UNEVEN' },
]

export function GripCreatePage() {
  const navigate = useNavigate()
  const createGrip = useCreateGrip()

  const [name, setName] = useState('')
  const [category, setCategory] = useState<GripCategory>('HANG')
  const [handMode, setHandMode] = useState<HandMode>('TWO_HANDS')
  const [fingers, setFingers] = useState<string[]>(['INDEX', 'MIDDLE', 'RING', 'PINKY'])
  const [gripType, setGripType] = useState<GripType>('HALF_CRIMP')
  const [edgeDepthMm, setEdgeDepthMm] = useState('20')
  const [edgeType, setEdgeType] = useState<EdgeType>('FLAT')

  const handleSubmit = async () => {
    if (!name.trim()) return
    await createGrip.mutateAsync({
      name: name.trim(),
      category,
      handMode,
      fingers: fingers as Finger[],
      gripType,
      edgeDepthMm: parseInt(edgeDepthMm) || 20,
      edgeType,
    })
    navigate('/statistics/grips')
  }

  return (
    <div className="space-y-6">
      <InputField label="Grip Name" value={name} onChange={e => setName(e.target.value)} placeholder="e.g. Gold standard 20mm" />

      <div>
        <label className="block text-sm font-medium text-text-secondary mb-2">Category</label>
        <Toggle
          options={[{ label: 'Hang', value: 'HANG' }, { label: 'Lift', value: 'LIFT' }]}
          value={category}
          onChange={v => setCategory(v as GripCategory)}
        />
      </div>

      <div>
        <label className="block text-sm font-medium text-text-secondary mb-2">Hand Mode</label>
        <Toggle
          options={[{ label: '2 Hands', value: 'TWO_HANDS' }, { label: '1 Hand', value: 'SINGLE_HAND' }]}
          value={handMode}
          onChange={v => setHandMode(v as HandMode)}
        />
      </div>

      <Collapsible title="Basic grip info" defaultOpen>
        <div className="space-y-4 pb-4">
          <div>
            <label className="block text-sm font-medium text-text-secondary mb-2">Fingers</label>
            <ChipSelect options={FINGER_OPTIONS} selected={fingers} onChange={setFingers} />
          </div>

          <Dropdown label="Grip Type" options={GRIP_TYPE_OPTIONS} value={gripType} onChange={e => setGripType(e.target.value as GripType)} />

          <InputField label="Edge Depth (mm)" type="number" value={edgeDepthMm} onChange={e => setEdgeDepthMm(e.target.value)} />

          <Dropdown label="Edge Type" options={EDGE_TYPE_OPTIONS} value={edgeType} onChange={e => setEdgeType(e.target.value as EdgeType)} />
        </div>
      </Collapsible>

      <Button onClick={handleSubmit} disabled={!name.trim() || createGrip.isPending} className="w-full">
        {createGrip.isPending ? 'Saving...' : 'Save Grip'}
      </Button>
    </div>
  )
}
