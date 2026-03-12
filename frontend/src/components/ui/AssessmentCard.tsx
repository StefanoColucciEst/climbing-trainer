import type { Assessment } from '../../types'

const TYPE_LABELS: Record<string, string> = {
  MAX_STRENGTH_7S: 'Max Strength (7s)',
  POWER_ENDURANCE_60PCT: 'Power Endurance (60%)',
  ENDURANCE_30PCT_HANG: 'Endurance (30% Hang)',
  MAX_STRENGTH_1RM: 'Max Strength (1RM)',
  ENDURANCE_30PCT_LIFT: 'Endurance (30% Lift)',
  CUSTOM: 'Custom',
}

interface AssessmentCardProps {
  assessment: Assessment
  onAddEntry?: () => void
}

export function AssessmentCard({ assessment, onAddEntry }: AssessmentCardProps) {
  const latest = assessment.entries[0]
  const label = assessment.customName || TYPE_LABELS[assessment.assessmentType] || assessment.assessmentType

  return (
    <div className="bg-card rounded-2xl p-4 shadow-sm mb-3">
      <div className="flex items-center justify-between mb-3">
        <h3 className="text-sm font-semibold text-text">{label}</h3>
        {onAddEntry && (
          <button onClick={onAddEntry} className="text-xs font-medium text-primary">
            + Add
          </button>
        )}
      </div>
      {latest ? (
        <div className="grid grid-cols-2 gap-3">
          {latest.resistanceKg != null && (
            <Metric label="Resistance" value={`${latest.resistanceKg} kg`} />
          )}
          {latest.bodyWeightPct != null && (
            <Metric label="% BW" value={`${latest.bodyWeightPct}%`} />
          )}
          {latest.resistanceLeftKg != null && (
            <Metric label="Left" value={`${latest.resistanceLeftKg} kg`} />
          )}
          {latest.resistanceRightKg != null && (
            <Metric label="Right" value={`${latest.resistanceRightKg} kg`} />
          )}
          {latest.numberOfHangs != null && (
            <Metric label="Hangs" value={`${latest.numberOfHangs}`} />
          )}
          {latest.timeUnderTensionSeconds != null && (
            <Metric label="TUT" value={`${latest.timeUnderTensionSeconds}s`} />
          )}
        </div>
      ) : (
        <p className="text-xs text-text-secondary">No entries yet</p>
      )}
    </div>
  )
}

function Metric({ label, value }: { label: string; value: string }) {
  return (
    <div>
      <div className="text-xs text-text-secondary">{label}</div>
      <div className="text-lg font-bold text-text">{value}</div>
    </div>
  )
}
