import { useNavigate } from 'react-router-dom'
import { useGrips } from '../../hooks/useGrips'
import { ListItem } from '../../components/ui/ListItem'
import { Button } from '../../components/ui/Button'
import { Plus } from 'lucide-react'

export function GripListPage() {
  const navigate = useNavigate()
  const { data: grips, isLoading } = useGrips()

  if (isLoading) return <div className="py-8 text-center text-text-secondary">Loading...</div>

  const hangs = grips?.filter(g => g.category === 'HANG') ?? []
  const lifts = grips?.filter(g => g.category === 'LIFT') ?? []

  return (
    <div>
      {hangs.length > 0 && (
        <>
          <h2 className="text-xs font-semibold text-text-secondary uppercase tracking-wide mb-3">Hangs</h2>
          {hangs.map(grip => (
            <ListItem
              key={grip.id}
              title={grip.name}
              subtitle={`${grip.gripType.replace(/_/g, ' ')} · ${grip.edgeDepthMm}mm`}
              onClick={() => navigate(`/statistics/grips/${grip.id}`)}
            />
          ))}
        </>
      )}

      {lifts.length > 0 && (
        <>
          <h2 className="text-xs font-semibold text-text-secondary uppercase tracking-wide mb-3 mt-6">Lifts</h2>
          {lifts.map(grip => (
            <ListItem
              key={grip.id}
              title={grip.name}
              subtitle={`${grip.gripType.replace(/_/g, ' ')} · ${grip.edgeDepthMm}mm`}
              onClick={() => navigate(`/statistics/grips/${grip.id}`)}
            />
          ))}
        </>
      )}

      <div className="mt-6">
        <Button onClick={() => navigate('/statistics/grips/new')} className="w-full flex items-center justify-center gap-2">
          <Plus className="w-4 h-4" /> Add Grip
        </Button>
      </div>
    </div>
  )
}
