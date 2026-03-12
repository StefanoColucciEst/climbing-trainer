import { useConditioning } from '../../hooks/useAssessments'
import { ListItem } from '../../components/ui/ListItem'

export function ConditioningPage() {
  const { data: exercises, isLoading } = useConditioning()

  if (isLoading) return <div className="py-8 text-center text-text-secondary">Loading...</div>

  return (
    <div>
      {exercises && exercises.length > 0 ? (
        exercises.map(ex => (
          <ListItem
            key={ex.id}
            title={ex.name}
            subtitle={ex.conditioningType.replace(/_/g, ' ')}
          />
        ))
      ) : (
        <p className="text-sm text-text-secondary">No conditioning exercises yet</p>
      )}
    </div>
  )
}
